pipeline {
    environment {
        SLACK_CHANNEL                       = "lastbounce-ui-automation-qa-ci-cd"
        SLACK_TOKEN_ID                      = "ds-slack-jenkins-tokencredentialid"
        SLACK_DOMAIN                        = "demandscience"
        GITHUB_TOKEN                        = credentials('ds-github-cred')
        GH_TOKEN                            = "${GITHUB_TOKEN_PSW}"
        BUILD_TIME                          = sh(script: "echo `date +%F-%H-%M-%S`", returnStdout: true).trim()
        GITHUB_URL                          = "https://github.com/demandscience/lastbounce-ui-automation-qa"
        GIT_REPO                            = 'lastbounce-ui-automation-qa'
    }

    options {
        ansiColor("xterm")
        disableConcurrentBuilds()
    }

    agent{
        label "spot-instance"
    }
   //triggers {
   //     cron '30 23 * * *'
    //}
    // Pipeline Initalisation
    stages {
        stage ('Initalization')  {
            steps {
                echo 'pipeline initalized'
            }
            
            post {
                success {
                    slackSend (teamDomain: SLACK_DOMAIN, tokenCredentialId: SLACK_TOKEN_ID, channel: SLACK_CHANNEL, color: '#00FF00', message:"## BRANCH: ${BRANCH_NAME}/${env.BUILD_NUMBER} ## GitHub: ${GITHUB_URL}/tree/${BRANCH_NAME}")
                }
            }
        }

        // PR Information
        stage ('GET PR INFO') {
            when {
                allOf {
                    not { expression { BRANCH_NAME ==~ /(PR-.*)/} }
                    not { triggeredBy 'TimerTrigger' }
                    not { triggeredBy cause: "UserIdCause" }
                }
            }
            environment {
                OPEN_PR   = "OPEN_PR.json"
                MERGED_PR = "MERGED_PR.json"
            }
            steps {
                script {
                    if(env.GIT_BRANCH ==~ /(DEVELOP|STAGING|PRE-PROD|PROD)/){
                        sh "gh pr list -B ${GIT_BRANCH} -L 1 --state merged > ${OPEN_PR}"
                        def PR_NUM =  sh(script: "awk '{print \$1}' $OPEN_PR", returnStdout: true).trim()
                        sh "gh pr view ${PR_NUM} > ${MERGED_PR}"
                        sh "cat ${MERGED_PR}"
                    }   
                    else{
                        sh "gh pr view ${GIT_BRANCH} > ${OPEN_PR}"
                        sh "cat ${OPEN_PR}"
                    }
                }
            }
            post {
                always {
                    script {
                        if (env.GIT_BRANCH ==~ /(DEVELOP|STAGING|PRE-PROD|PROD)/) {  
                            def PR_STATE                =  sh(script: "awk 'END {print \$(NF-4)}' $OPEN_PR", returnStdout: true).trim()
                            def PR_NUMBER               =  sh(script: "awk '{print \$1}' $OPEN_PR", returnStdout: true).trim()
                            def MERGED_FEATURE_BRANCH   =  sh(script: "awk 'END {print \$(NF-5)}' $OPEN_PR", returnStdout: true).trim()
                            def PR_AUTHOR               =  sh(script: "echo `awk -F 'author:' '{print \$2}' $MERGED_PR`", returnStdout: true).trim()
                            def PR_LINK                 =  sh(script: "echo `awk -F 'url:' '{print \$2}' $MERGED_PR`", returnStdout: true).trim()
                            def PR_REVIEWER             =  sh(script: "echo `awk -F 'reviewers:' '{print \$2}' $MERGED_PR`", returnStdout: true).trim()

                            slackSend (teamDomain: SLACK_DOMAIN, tokenCredentialId: SLACK_TOKEN_ID, channel: SLACK_CHANNEL, color: '#00FF00', message: "## BRANCH/BUILD NUMBER: ${GIT_BRANCH}/${BUILD_NUMBER} \n ## PR STATE: ${PR_STATE} \n ## PR NUMBER: ${PR_NUMBER} \n ## MERGED FEATURE BRANCH: ${MERGED_FEATURE_BRANCH} \n ## PR OWNER: ${PR_AUTHOR} \n ## PR REVIEWER: ${PR_REVIEWER} \n ## PR LINK: ${PR_LINK} ")
                        }
                        else {
                            def PR_TITLE    =  sh(script: "echo `awk -F 'title:' '{print \$2}' $OPEN_PR`", returnStdout: true).trim()
                            def PR_STATE    =  sh(script: "echo `awk -F 'state:' '{print \$2}' $OPEN_PR`", returnStdout: true).trim()
                            def PR_NUMBER   =  sh(script: "echo `awk -F 'number:' '{print \$2}' $OPEN_PR`", returnStdout: true).trim()
                            def PR_AUTHOR   =  sh(script: "echo `awk -F 'author:' '{print \$2}' $OPEN_PR`", returnStdout: true).trim()
                            def PR_REVIEWER =  sh(script: "echo `awk -F 'reviewers:' '{print \$2}' $OPEN_PR`", returnStdout: true).trim()
                            def PR_LINK     =  sh(script: "echo `awk -F 'url:' '{print \$2}' $OPEN_PR`", returnStdout: true).trim()

                            slackSend (teamDomain: SLACK_DOMAIN, tokenCredentialId: SLACK_TOKEN_ID, channel: SLACK_CHANNEL, color: '#00FF00', message: "## BRANCH/BUILD NUMBER: ${GIT_BRANCH}/${BUILD_NUMBER} \n ## PR TITLE: ${PR_TITLE} \n ## PR STATE: ${PR_STATE} \n ## PR NUMBER: ${PR_NUMBER} \n ## PR OWNER: ${PR_AUTHOR} \n ## PR REVIEWER: ${PR_REVIEWER} \n ## PR LINK: ${PR_LINK}")
                        }
                    }
                }
            }
        }
        // Download file from S3
        stage('Download file from S3') {
            steps {
                script {
                sh "aws s3 cp s3://shared-ds-qa-automation-bucket/LastBounce_Credentials.config ./"
                }
            }
        }

    
        // Regression Test
        stage('Regression Test') {
           when {
                not { expression { BRANCH_NAME ==~ /(PR-.*)/} }
            	}

	    steps {  
		script { 
			wrap([$class: 'Xvfb']){
			    if (env.GIT_BRANCH == 'DEVELOP') {
			       sh 'mvn clean install test -B -Dspring.profiles.active=dev'
			    }
			    else if (env.GIT_BRANCH == 'STAGING') {  
			       sh 'mvn clean install test -B -Dspring.profiles.active=staging'
			    }
			    else if (env.GIT_BRANCH == 'PRE-PROD') {
			       sh 'mvn clean install test -B -Dspring.profiles.active=preprod'
			    }
			    else if (env.GIT_BRANCH == 'PROD') {
			       sh 'mvn clean install test -B -Dspring.profiles.active=prod'
			    }
			    else {
 			       sh 'mvn clean test "-Dcucumber.filter.tags=@upload_test" -B -Dspring.profiles.active=dev'
			    }
			}
		}
	    }
            post {
                success {
                    script {
                        sh "cat ${WORKSPACE}/target/cucumber-reports/Cucumber.xml | grep 'testsuite' "
                        def REG_RESULT =  sh script: "cat ${WORKSPACE}/target/cucumber-reports/Cucumber.xml  | grep 'testsuite' ", returnStdout: true 
                        sh "echo '${REG_RESULT}'"
                        slackSend (teamDomain: SLACK_DOMAIN, tokenCredentialId: SLACK_TOKEN_ID, channel: SLACK_CHANNEL, color: '#00FF00', message: "## BRANCH: ${BRANCH_NAME}/${env.BUILD_NUMBER} ## SUCCESSFUL: Regression Test Status - ${env.BUILD_URL}\n ## REGRESSION TESTS RESULT: ${REG_RESULT}")
                    }
                }
                failure {
                    script {
                        sh "cat ${WORKSPACE}/target/cucumber-reports/Cucumber.xml | grep 'testsuite' "
                        def REG_RESULT =  sh script: "cat ${WORKSPACE}/target/cucumber-reports/Cucumber.xml  | grep 'testsuite' ", returnStdout: true 
                        sh "echo '${REG_RESULT}'"
                        slackSend (teamDomain: SLACK_DOMAIN, tokenCredentialId: SLACK_TOKEN_ID, channel: SLACK_CHANNEL, color: '#FF0000', message: "## BRANCH:${BRANCH_NAME}/${env.BUILD_NUMBER} ## FAILURE: Regression Test Status - ${env.BUILD_URL}\n ## REGRESSION TESTS RESULT: ${REG_RESULT}")
                    }     
                }   
		        // Tag Source Code of UI replyforce
                always {
                    script {
                        if (currentBuild.rawBuild.getCause(hudson.triggers.TimerTrigger$TimerTriggerCause) == null) {
                            withCredentials([gitUsernamePassword(credentialsId: 'ds-github-cred')]) {        
                                sh "git tag ${GIT_REPO}-${GIT_BRANCH}-${BUILD_TIME}-${BUILD_NUMBER}"
                                sh "git push ${GITHUB_URL}.git  ${GIT_REPO}-${GIT_BRANCH}-${BUILD_TIME}-${BUILD_NUMBER}"
                            }
                        }
                    }  
                }     
            }
        }
    }
        
    post {
        always {
            script {
		if (env.GIT_BRANCH ==~ /(PR-.*)/ ) {
		    echo "no need to generate cucumber report"
		}
		else {
		    cucumber buildStatus: "UNSTABLE",
		    fileIncludePattern: "**/Cucumber.json",
		    jsonReportDirectory: "target"
		}
	    }
        }  
        success {
            script {
                slackSend (teamDomain: SLACK_DOMAIN, tokenCredentialId: SLACK_TOKEN_ID, channel: SLACK_CHANNEL, color: '#00FF00', message: "## BRANCH: ${BRANCH_NAME}/${env.BUILD_NUMBER} ## SUCCESSFUL: Lastbounce QA Pipeline - ${env.BUILD_URL} \n ## Pipeline Duration: ${currentBuild.durationString.replace(' and counting', '')}")
            }             
        }
        failure {
            script {
                slackSend (teamDomain: SLACK_DOMAIN, tokenCredentialId: SLACK_TOKEN_ID, channel: SLACK_CHANNEL, color: '#FF0000', message: "## BRANCH:${BRANCH_NAME}/${env.BUILD_NUMBER} ## FAILURE: Lastbounce QA Pipeline- ${env.BUILD_URL}\n ## Pipeline Duration: ${currentBuild.durationString.replace(' and counting', '')} ")
            }            
        }     
        aborted {
            script {
                currentBuild.result = "ABORTED"
                echo currentBuild.result
                slackSend (teamDomain: SLACK_DOMAIN, tokenCredentialId: SLACK_TOKEN_ID, channel: SLACK_CHANNEL, color: '#FFA500',  message: "## BRANCH: ${BRANCH_NAME}/${env.BUILD_NUMBER} ## ABORTED: Lastbounce QA Pipeline - ${env.BUILD_URL} \n ## Pipeline Duration: ${currentBuild.durationString.replace(' and counting', '')}")
            }
        }
    } 
}

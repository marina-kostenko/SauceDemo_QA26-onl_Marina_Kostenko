pipeline {
    agent any

    tools {

        maven "m3"
    }

    stages {
        stage('Run tests') {
            steps {

                git 'https://github.com/marina-kostenko/SauceDemo_QA26-onl_Marina_Kostenko.git'


                bat "mvn -Dmaven.test.failure.ignore=true clean test"


            }

            post {

                success {
                    junit '**/target/surefire-reports/TEST-*.xml'

                }
            }
        }
    }
}

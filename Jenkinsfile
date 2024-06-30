pipeline {
    agent any

    parameters {
        choice(name: 'BROWSER', choices: ['edge', 'chrome', 'safari'], description: 'Choose browser')
        choice(name: 'SUITE', choices: ['smoke', 'regression'], description: 'Choose type of suite')
        booleanParam(name: 'HEADLESS', defaultValue: true, description: 'Run in headless mode')
    }
    triggers{
        parameterizedCron('''
            00 09 * * 1,3,5 %SUITE=smoke;%BROWSER=chrome;%HEADLESS=true
            00 23 1-31/2 * * %SUITE=regression;%BROWSER=${BROWSER};%HEADLESS=true
        ''')
    }
    tools {
        maven "m3"
    }

    stages {
        stage('Run tests') {
            steps {
                git 'https://github.com/marina-kostenko/SauceDemo_QA26-onl_Marina_Kostenko.git'
                bat "mvn -Dmaven.test.failure.ignore=true -DsuiteName=${params.SUITE} -Dbrowser=${params.BROWSER} -Dheadless=${params.HEADLESS} clean test"

            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'

                }
            }
        }
        stage('Generate allure report') {
                    steps {
                       allure includeProperties: false, report: 'target/allure-report', results: [[path: 'target/allure-results']]

                    }


        }
    }
}

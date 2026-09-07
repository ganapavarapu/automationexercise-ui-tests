pipeline {
    agent {
         label 'windows-ui'
    }

     tools {
            allure 'Allure'
        }

    stages {
        stage('Run Tests') {
            steps {
            bat 'mvn clean test -Dbrowser=chrome -Dheadless=false -DbaseUrl=https://automationexercise.com'
            }
        }
    }

    post {
            always {
                allure results: [[path: 'target/allure-results']]
            }
        }
}
pipeline {
    agent any

     tools {
            allure 'Allure'
        }

    stages {
        stage('Run Tests') {
            steps {
            bat 'mvn clean test -Dbrowser=chrome -Dheadless=false -DbaseUrl=https://automationexercise.com -DloginPath=/login'
            }
        }
    }

    post {
            always {
                allure results: [[path: 'target/allure-results']]
            }
        }
}
pipeline {
    agent any

     tools {
            allure 'Allure'
        }

    stages {
        stage('Run Tests') {
            steps {
            bat 'mvn clean test -Dbrowser=chrome -Dheadless=true -DbaseUrl=https://automationexercise.com'
            }
        }
    }

    post {
            always {
                allure results: [[path: 'target/allure-results']]
            }
        }
}
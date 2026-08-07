pipeline {
    agent any

     tools {
            allure 'Allure'
        }

    stages {
        stage('Run Tests') {
            steps {
            bat 'mvn clean test'
            }
        }
    }

    post {
            always {
                allure results: [[path: 'target/allure-results']]
            }
        }
}
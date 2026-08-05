pipeline {
    agent any

    stages {
        stage('Run Tests') {
            steps {
                bat '''
                cd "C:\\Users\\vikra\\IdeaProjects\\automationexercise-ui-tests"
                mvn clean test
                '''
            }
        }
    }
}
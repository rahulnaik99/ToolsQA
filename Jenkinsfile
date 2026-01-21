pipeline {
    agent any

    tools {
        maven 'maven3'
        jdk 'jdk17'
    }

    parameters {
        choice(
            name: 'BROWSER',
            choices: ['chrome', 'firefox', 'edge'],
            description: 'Select browser'
        )
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Building project (skip tests)..."
                sh 'mvn clean compile -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                echo "Running tests..."
                sh """
                mvn test -Dbrowser=${params.BROWSER}
                """
            }
        }
    }

    post {
        always {
            echo "Publishing reports..."
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
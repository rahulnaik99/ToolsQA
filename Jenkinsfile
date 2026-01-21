pipeline {
    agent any

//     tools {
//         maven 'maven3'
//         jdk 'jdk17'
//     }

    parameters {
        choice(
            name: 'BROWSER',
            choices: ['chrome', 'firefox', 'edge'],
            description: 'Select browser'
        )
        choice(
            name: 'ENV',
            choices: ['qa', 'uat', 'prod'],
            description: 'Select environment'
        )
        booleanParam(
            name: 'HEADLESS',
            defaultValue: false,
            description: 'Run tests in headless mode'
        )
        string(
            name: 'THREAD_COUNT',
            defaultValue: '3',
            description: 'TestNG thread count'
        )
        string(
            name: 'SUITE1',
            defaultValue: 'testng.xml',
            description: 'TestNG suite file 1'
        )
        string(
            name: 'SUITE2',
            defaultValue: 'testng1.xml',
            description: 'TestNG suite file 2'
        )
    }

    environment {
        EVIDENCE_DIR = "${WORKSPACE}/TestEvidences"
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Checking out source code..."
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Building project (skip tests)..."
                bat 'mvn clean compile -DskipTests'
            }
        }

        stage('Run Parallel Tests') {
            parallel {

                stage('Suite 1 Execution') {
                    steps {
                        echo "Running Suite 1..."
                        bat """
                        mvn test ^
                        -DsuiteXmlFile=${params.SUITE1} ^
                        -Dbrowser=${params.BROWSER} ^
                        -Denv=${params.ENV} ^
                        -Dheadless=${params.HEADLESS} ^
                        -DthreadCount=${params.THREAD_COUNT} ^
                        -Dreport.dir=reports-suite1
                        """
                    }
                }

                stage('Suite 2 Execution') {
                    steps {
                        echo "Running Suite 2..."
                        bat """
                        mvn test ^
                        -DsuiteXmlFile=${params.SUITE2} ^
                        -Dbrowser=${params.BROWSER} ^
                        -Denv=${params.ENV} ^
                        -Dheadless=${params.HEADLESS} ^
                        -DthreadCount=${params.THREAD_COUNT} ^
                        -Dreport.dir=reports-suite2
                        """
                    }
                }
            }
        }
    }

    post {
        always {
            echo "Archiving Test Evidence..."
            archiveArtifacts artifacts: '**/TestEvidences/**', allowEmptyArchive: true

            echo "Publishing TestNG reports..."
            junit '**/target/**/surefire-reports/*.xml'
        }

        success {
            echo "✅ Tests completed successfully!"
        }

        failure {
            echo "❌ Test failures detected. Check reports."
        }
    }
}
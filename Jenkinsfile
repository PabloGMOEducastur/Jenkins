pipeline {
    agent any
    tools {
        jdk 'Java21'
        maven 'Maven'
    }

    environment {
        PROJECT_VERSION = '1.5.0-SNAPSHOT'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/PabloGMOEducastur/ExamenMocPGM.git'
            }
        }

        stage('Build') {
            steps {
                bat 'echo Limpiando y compilando el proyecto con Maven...'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'echo Ejecutando tests con Maven'
                bat 'mvn test'
            }
        }

        stage('Move jar') {
            steps {
                bat """
                  echo Eliminando directorio versiones
                  if exist versiones rmdir /S /Q versiones
                  echo Se crea el directorio versiones con la última versión de la API
                  mkdir versiones
                  copy target\\*-${env.PROJECT_VERSION}.jar versiones\\
                """
            }
        }
    }

    post {
        success {
            bat 'echo Pipeline completado correctamente.'
        }
        failure {
            bat 'echo Ha ocurrido un error durante la ejecución del pipeline.'
        }
    }
}
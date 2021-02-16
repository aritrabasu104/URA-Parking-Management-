pipeline{
   agent any
   script {
   env.JAVA_HOME="${tool 'openjdk11'}"
   env.PATH="${env.JAVA_HOME}/bin:${env.PATH}"
   }
   tools {
        maven 'Maven3' 
    }
   stages{
   		stage('SCM Checkout'){
   			steps{
    			git 'https://github.com/aritrabasu104/URA-Parking-Management-.git'
    		}
    	}
        stage('Mvn Build'){
             steps{
             	sh 'mvn clean package'
     		}
        }
    }
    post{
    	always{
    		cleanWs()
    	}
    }
       
}
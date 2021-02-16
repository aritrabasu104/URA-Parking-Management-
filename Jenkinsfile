pipeline{
   agent any
   
   tools {
        maven 'Maven3' 
		jdk 'openjdk11'
    }
   stages{
   		stage('SCM Checkout'){
   			steps{
    			git 'https://github.com/aritrabasu104/URA-Parking-Management-.git'
    		}
    	}
        stage('Mvn Build'){
             steps{
				sh 'java -version'
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
pipeline{
   agent any
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
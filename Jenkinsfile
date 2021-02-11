pipeline{
   agent any
   stages{
   		stage('SCM Checkout'){
    		git 'https://github.com/aritrabasu104/URA-Parking-Management-.git'
    	}
        stage('Mvn Build'){
              sh 'mvn clean package'
     
        }
    }
    post{
    	always{
    		cleanWs()
    	}
    }
       
}
node{
   
    stages{
    	stage('SCM Checkout'){
    		git 'https://github.com/aritrabasu104/URA-Parking-Management-.git'
    	}
        stage('Mvn Build'){
                steps{
                    sh 'mvnw clean package'
                }
            }
        
     
        }
       
}
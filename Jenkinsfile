pipeline
{
    agent any
    
    stages 
    {
        stage('Build')
        {
            steps
            {
                echo 'Build App'
            }
              
        }
        
        stage('Test')
        {
            steps
            {
                echo 'Test App'
            }
              
        }
        
        stage('Deploy')
        {
            steps
            {
                echo 'Deploy App'
            }
              
        }
        
    }
        
        post
        {
            always
            {
                emailext body: 'This is Jenkins Pipeline Summary', subject: 'Jenkins Pipeline Summary', to: 'mogalisuraj2000@gmail.com'
            }
            
        }
        
        
       
    }

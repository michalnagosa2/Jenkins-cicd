node('linux')
enviroment{
	credentialsID = ''
}
def customeImage = ''
stage('git'){
	git branch: 'master',
	   url:https://github.com/michalnagosa2/flask-http/blob/master/app.py
}

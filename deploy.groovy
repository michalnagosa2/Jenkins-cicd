node('linux'){
def customImage = ""
environment{
    registry = 'michalnagosa96/opsschool-repo'
    registryCredential = 'docker.michal,nagosa96'
    customImage = ''
}
stage('git'){
git branch: 'master',
url:'https://github.com/michalnagosa2/flask-http/blob/master/app.py'
}
stage("create dockerfile") {
sh """
tee Dockerfile <<-'EOF'
FROM ubuntu:14.04
MAINTAINER Docker Education Team <education@docker.com>
RUN apt-get update
RUN DEBIAN_FRONTEND=noninteractive apt-get install -y -q python-all python-pip 
ADD ./webapp/requirements.txt /tmp/requirements.txt
RUN pip install -qr /tmp/requirements.txt
ADD ./webapp /opt/webapp/
WORKDIR /opt/webapp
EXPOSE 5000
CMD ["python", "app.py"]
EOF
"""
}
stage('Build image') {
customImage = docker.build('michalnagosa96/opsschool-repo:tag')
}
stage("Push image") {
docker.withRegistry('https://registry-1.docker.io/v1', 'docker.michal,nagosa96') {
customImage.push()
}
}
}
	

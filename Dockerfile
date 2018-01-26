FROM jenkins/jenkins

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false -Djenkins.CLI.disabled=true"
 
COPY admin.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy
COPY csrf.groovy /usr/share/jenkins/ref/init.groovy.d/csrf.groovy
 
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt



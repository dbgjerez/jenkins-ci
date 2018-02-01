FROM jenkins/jenkins

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false -Djenkins.CLI.disabled=true"
 
COPY scripts/admin.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy
COPY scripts/csrf.groovy /usr/share/jenkins/ref/init.groovy.d/csrf.groovy
COPY scripts/configure-jnlp-agent-protocol.groovy /usr/share/jenkins/ref/init.groovy.d/configure-jnlp-agent-protocol.groovy
 
COPY plugins/plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt



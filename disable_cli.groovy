import jenkins.*
import jenkins.model.*
import hudson.model.*
import java.util.logging.Logger

Logger logger = Logger.getLogger("cli-shutdown.groovy")
logger.info("Disabling the Jenkins CLI...")

// disabled CLI access over TCP listener (separate port)
def p = AgentProtocol.all()
p.each { x ->
    if (x.name?.contains("CLI")) {
        logger.info("Removing protocol ${x.name}")
        p.remove(x)
    }
}

// disable CLI access over /cli URL
def removal = { lst ->
    lst.each { x ->
        if (x.getClass().name.contains("CLIAction")) {
            logger.info("Removing extension ${x.getClass().name}")
            lst.remove(x)
        }
    }
}
def j = Jenkins.instance
removal(j.getExtensionList(RootAction.class))
removal(j.actions)
logger.info("CLI disabled")

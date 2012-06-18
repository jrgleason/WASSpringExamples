if [ $# -ne 6 ]
then 
   echo "Please provide the following ordered parameters [Server AppName WARLocation remoteName username serviceName]"
   exit
fi
echo scp "$3" $5@$1:~/$4

scp "$3" $5@$1:~/$4.war

ssh $5@$1 "/opt/IBM/WebSphere/AppServer/bin/wsadmin.sh -lang jython -c \"AdminApp.update('$2', 'app', '[  -operation update -contents $4.war]' )\""

ssh $5@$1 "/opt/IBM/WebSphere/AppServer/bin/wsadmin.sh -lang jython -c \"AdminConfig.save()\""

# Regenerate Plugin
echo "Generating Plugin Config"
ssh -T $5@$1 <<\EOI
/opt/IBM/WebSphere/AppServer/profiles/bucks/bin/GenPluginCfg.sh
cp /opt/IBM/WebSphere/AppServer/profiles/bucks/config/cells/plugin-cfg.xml /opt/IBM/WebSphere/Plugins/config/webserver1/
exit
EOI
# Not currently working
# Restart Apache
# echo "Restarting IHS"


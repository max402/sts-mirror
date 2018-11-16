FROM jboss/keycloak:4.4.0.Final

ADD docker/cli/init_keycloak.cli /install/init_keycloak.cli

ADD target/sts-keycloak-adapter.tar.gz /

RUN cd /install && /opt/jboss/keycloak/bin/jboss-cli.sh --file=/install/init_keycloak.cli

RUN rm -rf /opt/jboss/keycloak/standalone/configuration/standalone_xml_history

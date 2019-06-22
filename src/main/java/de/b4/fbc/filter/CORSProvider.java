package de.b4.fbc.filter;

import de.b4.fbc.util.CallRest;
import org.jboss.resteasy.plugins.interceptors.CorsFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSProvider implements Feature {
  private final Logger log = LoggerFactory.getLogger(CORSProvider.class);

  @Override
  public boolean configure(FeatureContext context) {
    log.info("CORSProvider configured");
    CorsFilter filter = new CorsFilter();
    filter.getAllowedOrigins().add("*");
    filter.setAllowedMethods("GET, POST, OPTIONS, HEAD");
    filter.setAllowedHeaders("accept, content-type, origin");
    context.register(filter);
    return true;
  }
}
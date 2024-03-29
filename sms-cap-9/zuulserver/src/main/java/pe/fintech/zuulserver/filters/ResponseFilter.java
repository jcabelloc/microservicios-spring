package pe.fintech.zuulserver.filters;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import brave.Tracer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ResponseFilter extends ZuulFilter{
    private static final int  FILTER_ORDER=1;
    private static final boolean  SHOULD_FILTER=true;
    private static final Logger logger = LoggerFactory.getLogger(ResponseFilter.class);
    
    @Autowired
    FilterUtils filterUtils;
    
    @Autowired
    Tracer tracer;

    @Override
    public String filterType() {
        return FilterUtils.POST_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        //logger.debug("Adding the correlation id to the outbound headers. {}", filterUtils.getCorrelationId());
        //ctx.getResponse().addHeader(FilterUtils.CORRELATION_ID, filterUtils.getCorrelationId());
        //logger.debug("Completing outgoing request for {}.", ctx.getRequest().getRequestURI());
        logger.debug("Adding the correlation id to the outbound headers. {}", tracer.currentSpan().context().traceIdString());
        ctx.getResponse().addHeader("correlation-id", tracer.currentSpan().context().traceIdString());
        logger.debug("Completing outgoing request for {}.", tracer.currentSpan().context().traceIdString());


        return null;
    }
}

package pl.net.kopczynski.routes;

import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.model.RouteDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.net.kopczynski.processors.HeadersFilterProcessor;

/**
 * Created by tkopczynski on 10/09/16.
 */
@Component
public class HelloRoute extends BaseRouteBuilder {

    @Autowired
    public HelloRoute(final HeadersFilterProcessor headersFilterProcessor) {
        super(headersFilterProcessor);
    }

    @Override
    protected ProcessorDefinition<RouteDefinition> prepareRoute() {
        rest().get("/hello").to("direct:hello");
        return from("direct:hello").setBody().constant("Hello world");
    }
}

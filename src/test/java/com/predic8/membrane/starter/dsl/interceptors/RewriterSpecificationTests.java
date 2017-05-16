package com.predic8.membrane.starter.dsl.interceptors;

import com.predic8.membrane.core.interceptor.rewrite.RewriteInterceptor.Mapping;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.predic8.membrane.core.interceptor.rewrite.RewriteInterceptor.Type.REDIRECT_TEMPORARY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@DisplayName("A RewriterSpecification")
class RewriterSpecificationTests {

    @Test
    @DisplayName("should add a mapping to the list of rewrite interceptor mappings")
    void testMap() {
        ArrayList<Mapping> mappings = new ArrayList<>();
        RewriterSpecification rewriterSpecification = new RewriterSpecification(mappings);
        rewriterSpecification.map("http://www.predic8.de", "http://www.p8.de");

        assertThat(mappings).hasSize(1)
                            .extracting("from", "to", "do")
                            .contains(tuple("http://www.predic8.de", "http://www.p8.de", REDIRECT_TEMPORARY));
    }
}
/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.dataprepper.plugins.processor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.opensearch.dataprepper.plugins.processor.configuration.EntryConfig;
import org.opensearch.dataprepper.test.helper.ReflectivelySetField;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
class GeoIPProcessorConfigTest {

    private GeoIPProcessorConfig geoIPProcessorConfig;

    @BeforeEach
    void setUp() {
        geoIPProcessorConfig = new GeoIPProcessorConfig();
    }

    @Test
    void testDefaultConfig() {
        assertThat(geoIPProcessorConfig.getEntries(), equalTo(null));
        assertThat(geoIPProcessorConfig.getTagsOnFailure(), equalTo(null));
    }

    @Test
    void testGetEntries() throws NoSuchFieldException, IllegalAccessException {
        List<EntryConfig> entries = new ArrayList<>();
        entries.add(new EntryConfig());
        ReflectivelySetField.setField(GeoIPProcessorConfig.class, geoIPProcessorConfig, "entries", entries);

        assertThat(geoIPProcessorConfig.getEntries(), equalTo(entries));
    }
}

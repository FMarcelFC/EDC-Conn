/*
 *  Copyright (c) 2021 Daimler TSS GmbH
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Daimler TSS GmbH - Initial API and Implementation
 *
 */

package org.eclipse.dataspaceconnector.ids.api.multipart.message;

import de.fraunhofer.iais.eis.Message;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class MultipartResponse {

    private final Message header;
    private final Object payload;

    private MultipartResponse(@NotNull Message header, @Nullable Object payload) {
        this.header = Objects.requireNonNull(header);
        this.payload = payload;
    }

    @NotNull
    public Message getHeader() {
        return header;
    }

    @Nullable
    public Object getPayload() {
        return payload;
    }

    public static class Builder {

        private Message header;
        private Object payload;

        private Builder() {
        }

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder header(@Nullable Message header) {
            this.header = header;
            return this;
        }

        public Builder payload(@Nullable Object payload) {
            this.payload = payload;
            return this;
        }

        public MultipartResponse build() {
            return new MultipartResponse(header, payload);
        }
    }
}

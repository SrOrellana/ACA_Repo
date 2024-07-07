/*
 * Copyright 2023 WeGotYou!
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.project.models.dtos;

public class CheckPointResponse {

    private boolean isInside;
    private Long idGeozone;

    public CheckPointResponse(boolean isInside, Long idGeozone) {
        this.isInside = isInside;
        this.idGeozone = idGeozone;
    }

    // Getters y setters
    public boolean isInside() {
        return isInside;
    }

    public void setInside(boolean inside) {
        isInside = inside;
    }

    public Long getIdGeozone() {
        return idGeozone;
    }

    public void setIdGeozone(Long idGeozone) {
        this.idGeozone = idGeozone;
    }
}

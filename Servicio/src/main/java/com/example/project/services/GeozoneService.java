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
package com.example.project.services;

import com.example.project.models.dtos.CreateGeozoneDTO;
import com.example.project.models.entities.GeoZone;

import java.util.List;

public interface GeozoneService {
    List<GeoZone> getAll();

    List<GeoZone> getAllActive();

    GeoZone getOneById(Long id);

    GeoZone createGeozone(CreateGeozoneDTO createGeozoneDTO);

    GeoZone activateGeozone(Long id);

    GeoZone deactivateGeozone(Long id);
}
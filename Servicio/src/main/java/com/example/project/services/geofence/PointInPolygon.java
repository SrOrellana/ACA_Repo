package com.example.project.services.geofence;

import com.example.project.models.entities.Coordinate;
import com.example.project.repositories.CoordenadasRepository;

import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;


import org.locationtech.jts.geom.Polygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PointInPolygon {

    @Autowired
    private CoordenadasRepository coordenadasRepository;

    public CheckPointResponse checkPointInGeozonePolygon(Long idGeozone, Double lat, Double lon) {
        // Validar parámetros de entrada
        if (idGeozone == null || lat == null || lon == null) {
            throw new IllegalArgumentException("Los parámetros idGeozone, lat y lon no deben ser nulos.");
        }

        // Obtener coordenadas de la geozona desde el repositorio
        List<Coordinate> coordenadas = coordenadasRepository.getGeozoneCoordinates(idGeozone);

        if (coordenadas == null || coordenadas.isEmpty()) {
            throw new IllegalArgumentException("No se encontraron coordenadas para la geozona especificada.");
        }

        // Convertir coordenadas a tipo org.locationtech.jts.geom.Coordinate usando streams
        org.locationtech.jts.geom.Coordinate[] coordinates = coordenadas.stream()
                .map(coord -> new org.locationtech.jts.geom.Coordinate(coord.getLatitud(), coord.getLongitud()))
                .toArray(org.locationtech.jts.geom.Coordinate[]::new);

        // Crear el polígono usando GeometryFactory
        GeometryFactory geometryFactory = new GeometryFactory();
        LinearRing linearRing = geometryFactory.createLinearRing(coordinates);
        Polygon polygon = geometryFactory.createPolygon(linearRing, null);

        // Crear el punto a verificar
        org.locationtech.jts.geom.Coordinate point = new org.locationtech.jts.geom.Coordinate(lat, lon);
        boolean isInside = polygon.contains(geometryFactory.createPoint(point));

        // Retornar respuesta encapsulada en CheckPointResponse
        return new CheckPointResponse(isInside, idGeozone);
    }
}

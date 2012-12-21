package com.google.gwt.maps.testing.client.maps;

/*
 * #%L
 * GWT Maps API V3 - Showcase
 * %%
 * Copyright (C) 2011 - 2012 GWT Maps API V3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapTypeId;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.overlays.MapCanvasProjection;
import com.google.gwt.maps.client.overlays.OverlayView;
import com.google.gwt.maps.client.overlays.overlayhandlers.OverlayViewMethods;
import com.google.gwt.maps.client.overlays.overlayhandlers.OverlayViewOnAddHandler;
import com.google.gwt.maps.client.overlays.overlayhandlers.OverlayViewOnDrawHandler;
import com.google.gwt.maps.client.overlays.overlayhandlers.OverlayViewOnRemoveHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * See <a href=
 * "https://developers.google.com/maps/documentation/javascript/layers.html#FusionTables"
 * >FusionTables API Doc</a>
 */
public class OverlayViewMapWidget extends Composite {

  private final VerticalPanel pWidget;

  private MapWidget mapWidget;

  public OverlayViewMapWidget() {
    pWidget = new VerticalPanel();
    initWidget(pWidget);

    draw();
  }

  private void draw() {
    pWidget.clear();
    pWidget.add(new HTML("<br>Custom Overlay View."));

    drawMap();
    //drawOverlay1();
    drawOverlay2();
  }

  private void drawMap() {
    LatLng center = LatLng.newInstance(40.740, -74.18);
    MapOptions opts = MapOptions.newInstance();
    opts.setZoom(13);
    opts.setCenter(center);
    opts.setMapTypeId(MapTypeId.HYBRID);

    mapWidget = new MapWidget(opts);
    pWidget.add(mapWidget);
    mapWidget.setSize("750px", "500px");
  }

//  private void drawOverlay1() {
//    String url = "http://www.lib.utexas.edu/maps/historical/newark_nj_1922.jpg";
//    LatLng sw = LatLng.newInstance(40.716216,-74.213393);
//    LatLng ne = LatLng.newInstance(40.765641,-74.139235);
//    LatLngBounds bounds = LatLngBounds.newInstance(sw, ne);
//    GroundOverlayOptions options = GroundOverlayOptions.newInstance(); 
//    
//    GroundOverlay groundOverlay = GroundOverlay.newInstance(url, bounds, options);
//    groundOverlay.setMap(mapWidget);
//  }
  
  private void drawOverlay2() {    
    OverlayViewOnDrawHandler onDrawHandler = new OverlayViewOnDrawHandler() {
      @Override
      public void onDraw(OverlayViewMethods methods) {
        MapCanvasProjection projection = methods.getProjection();
        
        //Window.alert("OverlayView draw() called...");
        System.out.println("OverlayView draw() called...");
      }
    };
    
    OverlayViewOnAddHandler onAddHandler = new OverlayViewOnAddHandler() {
      @Override
      public void onAdd(OverlayViewMethods methods) {
        //Window.alert("OverlayView add() called...");
        System.out.println("OverlayView add() called...");
      }
    };
    
    OverlayViewOnRemoveHandler onRemoveHnadler = new OverlayViewOnRemoveHandler() {
      @Override
      public void onRemove(OverlayViewMethods methods) {
        //Window.alert("OverlayView remove() called...");
        System.out.println("OverlayView remove() called...");
      }
    };
    
    OverlayView overlay = OverlayView.newInstance(mapWidget, onDrawHandler, onAddHandler, onRemoveHnadler);
  }
  
}

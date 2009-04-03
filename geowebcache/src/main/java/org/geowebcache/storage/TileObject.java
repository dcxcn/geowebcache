/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Arne Kepp / The Open Planning Project 2009
 *  
 */
package org.geowebcache.storage;

public class TileObject extends StorageObject {
    public static final String TYPE = "tile";
    
    long tile_id = -1L;
    
    byte[] blob;
    
    long parameters_id = -1;
    
    long layer_id = -1L;
    
    long format_id = -1L;
    
    long[] xyz;
    
    String layer_name;
    
    String parameters;
    
    int srs = -1;
        
    public static TileObject createQueryTileObject(
            String layerName, long[] xyz, int srs, String format, String parameters) {
        TileObject obj = new TileObject();
        
        obj.layer_name = layerName;
        obj.xyz = xyz;
        obj.srs = srs;
        obj.blob_format = format;
        obj.parameters = parameters;
        
        return obj;
    }
    
    public static TileObject createCompleteTileObject(
            String layerName, long[] xyz, int srs, String format, 
            String parameters, byte[] blob) {
        TileObject obj = new TileObject();
        
        obj.layer_name = layerName;
        obj.xyz = xyz;
        obj.srs = srs;
        obj.blob_format = format;
        obj.parameters = parameters;
        
        if(blob == null) {
            obj.blob_size = -1;
        } else {
            obj.blob_size = blob.length;
            obj.blob = blob;
        }
        
        obj.created = System.currentTimeMillis();
        return obj;
    }
    
    private TileObject() {
        
    }
    
    public byte[] getBlob() {
        return blob;
    }
    
    public void setBlob(byte[] blob) {
        if(blob != null) {
            this.blob_size = blob.length;
        } else {
            this.blob_size = -1;
        }
        
        this.blob = blob;
    }
        
    public long getId() {
        return tile_id;
    }
    
    public void setId(long tile_id) {
        this.tile_id = tile_id;
    }

    public long getFormatId() {
        return this.format_id;
    }
    
    public void setFormatId(long format_id) {
        this.format_id = format_id;
    }

    public long getLayerId() {
        return this.layer_id;
    }
    
    public void setLayerId(long layer_id) {
        this.layer_id = layer_id;
    }

    
    public long getParametersId() {
        return this.parameters_id;
    }
    
    public void setParamtersId(long parameters_id) {
        this.parameters_id = parameters_id;
    }

    
    public long[] getXYZ() { 
        return xyz;
    }
    
    public int getSrs() {
        return srs;
    }
    
    public String getLayerName() {
        return layer_name;
    }
    
    public String getParameters() {
        return parameters;
    }
    
    public String getType() {
        return TYPE;
    }

}
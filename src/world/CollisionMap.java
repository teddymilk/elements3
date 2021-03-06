package world;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.tiled.TiledMap;

public class CollisionMap extends TiledMap {
	
	private int tileSize;

	public CollisionMap(String ref) throws SlickException {
		super(ref);
		this.tileSize = getTileHeight();		
	}
	
	public boolean isBlocked(Point p) {
		// expects pixel coordinates
		int col = (int) p.getX() / tileSize;
		int row = (int) p.getY() / tileSize;
		int tileId = getTileId(col, row, 0);
		String val = getTileProperty(tileId, "blocked", "false");
		return val.equals("true");
	}
	
	public int getTileSize() {
		return tileSize;
	}

}

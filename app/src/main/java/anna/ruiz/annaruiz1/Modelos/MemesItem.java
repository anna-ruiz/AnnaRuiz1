package anna.ruiz.annaruiz1.Modelos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "meme")
public class MemesItem{
	@DatabaseField(canBeNull = false)
	private String name;
	@DatabaseField()
	private int width;
	@DatabaseField(canBeNull = false)
	private String id;
	@DatabaseField()
	private String url;
	@DatabaseField()
	private int captions;
	@DatabaseField()
	private int height;
	@DatabaseField()
	private int boxCount;

	public MemesItem() {
	}


	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setCaptions(int captions){
		this.captions = captions;
	}

	public int getCaptions(){
		return captions;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	public void setBoxCount(int boxCount){
		this.boxCount = boxCount;
	}

	public int getBoxCount(){
		return boxCount;
	}

	@Override
 	public String toString(){
		return 
			"MemesItem{" + 
			"name = '" + name + '\'' + 
			",width = '" + width + '\'' + 
			",id = '" + id + '\'' + 
			",url = '" + url + '\'' + 
			",captions = '" + captions + '\'' + 
			",height = '" + height + '\'' + 
			",box_count = '" + boxCount + '\'' + 
			"}";
		}
}

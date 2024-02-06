package anna.ruiz.annaruiz1.Modelos;

public class MemesItem{
	private String name;
	private int width;
	private String id;
	private String url;
	private int captions;
	private int height;
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

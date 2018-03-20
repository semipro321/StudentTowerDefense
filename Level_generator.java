import java.util.ArrayList;

public class Level_generator 
{
	private ArrayList<Enemy> wave = new ArrayList<Enemy>();
	private ArrayList<Tower> arsenal = new ArrayList<Tower>();
	private int TA_populate;
	private int researcher_populate;
	private int level;
	private final int LEVEL_TOTAL = 3;
	
	public ArrayList<Tower> get_arsenal()
	{
		return this.arsenal;
	}
	
	public void add_to_arsenal(Tower tower) 
	{
		this.arsenal.add(tower);
	}
	
	public ArrayList<Enemy> get_wave()
	{
		create_wave();
		return this.wave;
	}
	
	public void set_populate() 
	{
		switch (level) 
		{
		case 1:
			this.TA_populate = 2;
			break;
		case 2:
			this.TA_populate = 4;
			break;
		case 3:
			this.TA_populate = 4;
			this.researcher_populate = 2;
			break;
		}
	}
	
	public int get_total_levels() 
	{
		return this.LEVEL_TOTAL;
	}
	
	public void increment_level() 
	{
		this.level += 1;
	}
	
	public Level_generator() 
	{
		this.level = 1;
		this.TA_populate = 0;
		this.researcher_populate = 0;
	}
	
	public void create_wave() 
	{
		this.wave.clear();
		set_populate();
		for (int i = 0; i < this.TA_populate; i++) 
		{
			Enemy enemy = new TA();
			this.wave.add(enemy);
		}
		for (int i = 0; i < this.researcher_populate; i++) 
		{
			Enemy enemy = new Researcher();
			this.wave.add(enemy);
		}
	}
	
	public boolean check_wave() 
	{
		for (Enemy enemy : this.wave) 
		{
			if ((enemy.get_health() > 0) && (enemy.get_x() != -1)) 
			{
				return true;
			}
		}
		return false;
	}
}
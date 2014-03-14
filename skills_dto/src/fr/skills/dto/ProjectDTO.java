package fr.skills.dto;


public class ProjectDTO {

	/***************************************** VARIABLES ***********************************************/
	private Integer id;
	private String name;

	/**************************************** CONSTRUCTORS *********************************************/
	public ProjectDTO(Integer id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}

	public ProjectDTO()
	{
		super();
	}

	/************************************** GETTERS/SETTERS ********************************************/
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}

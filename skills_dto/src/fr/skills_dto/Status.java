package fr.skills_dto;

public enum Status { 
	EnCours("En cours", 1),
	Terminer("Terminée", 2), 
	Supendue("Suspendue", 3),
	Annuler("Annulée", 4),
	Fermer("Fermée", 5);
	
	private String name ="";
	private Integer value = 0;
	
	Status(String name, Integer value){
		this.name = name;
		this.value = value;
	}
	public String toString(){
		return this.name;
	}	
	public Integer getValue(){
		return this.value;
	}	
	
	public static Status getStatus(int anId){
		Status vRet=null;
		for (Status vElement : Status.values())
		{
			if (vElement.getValue()== anId)
			{
				vRet = vElement;
				break;
			}
		}
		return vRet;
	}
}
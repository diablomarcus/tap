package net.katerberg.tap;

public class CustomDie {
	private Integer customDieId;
	private Integer numberOfDice;
	private Integer maxValue;
	private Integer modifier;
	

	
	public CustomDie() {
	}
	
	public CustomDie(Integer customDieId, Integer numberOfDice, Integer maxValue, Integer modifier) {
		this.customDieId = customDieId;
		this.numberOfDice = numberOfDice;
		this.maxValue = maxValue;
		this.modifier = modifier;
	}

	
	
	public Integer getCustomDieId() {
		return customDieId;
	}

	public void setCustomDieId(Integer customDieId) {
		this.customDieId = customDieId;
	}

	public Integer getNumberOfDice() {
		return numberOfDice;
	}

	public void setNumberOfDice(Integer numberOfDice) {
		this.numberOfDice = numberOfDice;
	}

	public Integer getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	public Integer getModifier() {
		return modifier;
	}

	public void setModifier(Integer modifier) {
		this.modifier = modifier;
	}
	
	

}

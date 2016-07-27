package com.ezdi.model;


import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CELLPHONE_MODEL")
public class CellphoneModel {
	
	@Id
	@Column(name = "MODEL_ID")
    @GeneratedValue
	private int id;
	@Column(name = "MODEL_NAME")
	private String modelName;
	@Column(name = "MODEL_COLOR")
	private String modelColor;
	@Column(name = "MODEL_SCREEN_SIZE")
	private float modelScreenSize;
	@Column(name = "MODEL_TYPE")
	private String modelType;
	@Column(name = "MODEL_OS")
	private String modelOS;
	@Column(name = "MODEL_PROCESSOR")
	private String modelProcessor;
	@Column(name = "MODEL_RAM")
	private int modelRAM;
	@Column(name = "MODEL_INTERNAL_MEMORY")
	private int modelInternalMemory;
	@Column(name = "MODEL_LENGTH")
	private float modelLength;
	@Column(name = "MODEL_BREADTH")
	private float modelBreadth;
	@Column(name = "MODEL_THICKNESS")
	private float modelThickness;
	@Column(name = "MODEL_RELEASE_DATE")
	private Date modelReleaseDate;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CELLPHONE_ID")
	private CellphoneBrand cellphoneBrand;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the modelName
	 */
	public String getModelName() {
		return modelName;
	}
	/**
	 * @param modelName the modelName to set
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	/**
	 * @return the modelColor
	 */
	public String getModelColor() {
		return modelColor;
	}
	/**
	 * @param modelColor the modelColor to set
	 */
	public void setModelColor(String modelColor) {
		this.modelColor = modelColor;
	}
	/**
	 * @return the modelSize
	 */
	public float getModelScreenSize() {
		return modelScreenSize;
	}
	/**
	 * @param modelSize the modelSize to set
	 */
	public void setModelScreenSize(float modelScreenSize) {
		this.modelScreenSize = modelScreenSize;
	}
	/**
	 * @return the modelType
	 */
	public String getModelType() {
		return modelType;
	}
	/**
	 * @param modelType the modelType to set
	 */
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}
	/**
	 * @return the modelOS
	 */
	public String getModelOS() {
		return modelOS;
	}
	/**
	 * @param modelOS the modelOS to set
	 */
	public void setModelOS(String modelOS) {
		this.modelOS = modelOS;
	}
	/**
	 * @return the modelProcessor
	 */
	public String getModelProcessor() {
		return modelProcessor;
	}
	/**
	 * @param modelProcessor the modelProcessor to set
	 */
	public void setModelProcessor(String modelProcessor) {
		this.modelProcessor = modelProcessor;
	}
	/**
	 * @return the modelRAM
	 */
	public int getModelRAM() {
		return modelRAM;
	}
	/**
	 * @param modelRAM the modelRAM to set
	 */
	public void setModelRAM(int modelRAM) {
		this.modelRAM = modelRAM;
	}
	/**
	 * @return the modelInternalMemory
	 */
	public int getModelInternalMemory() {
		return modelInternalMemory;
	}
	/**
	 * @param modelInternalMemory the modelInternalMemory to set
	 */
	public void setModelInternalMemory(int modelInternalMemory) {
		this.modelInternalMemory = modelInternalMemory;
	}
	/**
	 * @return the modelLength
	 */
	public float getModelLength() {
		return modelLength;
	}
	/**
	 * @param modelLength the modelLength to set
	 */
	public void setModelLength(float modelLength) {
		this.modelLength = modelLength;
	}
	/**
	 * @return the modelBreadth
	 */
	public float getModelBreadth() {
		return modelBreadth;
	}
	/**
	 * @param modelBreadth the modelBreadth to set
	 */
	public void setModelBreadth(float modelBreadth) {
		this.modelBreadth = modelBreadth;
	}
	/**
	 * @return the modelThickness
	 */
	public float getModelThickness() {
		return modelThickness;
	}
	/**
	 * @param modelThickness the modelThickness to set
	 */
	public void setModelThickness(float modelThickness) {
		this.modelThickness = modelThickness;
	}
	/**
	 * @return the modelReleaseDate
	 */
	public Date getModelReleaseDate() {
		return modelReleaseDate;
	}
	/**
	 * @param modelReleaseDate the modelReleaseDate to set
	 */
	public void setModelReleaseDate(Date modelReleaseDate) {
		this.modelReleaseDate = modelReleaseDate;
	}
	/**
	 * @return the cellphoneBrand
	 */
	public CellphoneBrand getCellphoneBrand() {
		return cellphoneBrand;
	}
	/**
	 * @param cellphoneBrand the cellphoneBrand to set
	 */
	public void setCellphoneBrand(CellphoneBrand cellphoneBrand) {
		this.cellphoneBrand = cellphoneBrand;
	}
	

}

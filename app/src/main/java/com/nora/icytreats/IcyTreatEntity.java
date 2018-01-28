package com.nora.icytreats;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "icy_treats")
public class IcyTreatEntity {

    @PrimaryKey(autoGenerate = true)
    private int id = 0;

    @NonNull
    private String name;

    @Nullable
    private String description = null;

    @NonNull
    private List<String> ingredients = new ArrayList<>();

    @NonNull
    private String instructions;

    @Nullable
    private String imageFilePath = null;

    @Nullable
    @DrawableRes
    private Integer drawableImageResourceId = null;

    private boolean createdByUser = false;

    public IcyTreatEntity(int id,
                          @NonNull String name,
                          @Nullable String description,
                          @NonNull List<String> ingredients,
                          @NonNull String instructions,
                          @Nullable String imageFilePath,
                          @Nullable Integer drawableImageResourceId,
                          boolean createdByUser) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.imageFilePath = imageFilePath;
        this.drawableImageResourceId = drawableImageResourceId;
        this.createdByUser = createdByUser;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @NonNull
    public List<String> getIngredients() {
        return ingredients;
    }

    @NonNull
    public String getInstructions() {
        return instructions;
    }

    @Nullable
    public String getImageFilePath() {
        return imageFilePath;
    }

    @Nullable
    public Integer getDrawableImageResourceId() {
        return drawableImageResourceId;
    }

    public boolean isCreatedByUser() {
        return createdByUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    public void setIngredients(@NonNull List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(@NonNull String instructions) {
        this.instructions = instructions;
    }

    public void setImageFilePath(@Nullable String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    public void setDrawableImageResourceId(@Nullable Integer drawableImageResourceId) {
        this.drawableImageResourceId = drawableImageResourceId;
    }

    public void setCreatedByUser(boolean createdByUser) {
        this.createdByUser = createdByUser;
    }
}

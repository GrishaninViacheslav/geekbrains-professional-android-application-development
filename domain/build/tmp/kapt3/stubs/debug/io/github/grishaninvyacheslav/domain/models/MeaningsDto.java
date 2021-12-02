package io.github.grishaninvyacheslav.domain.models;

import java.lang.System;

@kotlinx.android.parcel.Parcelize()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u00d6\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001c"}, d2 = {"Lio/github/grishaninvyacheslav/domain/models/MeaningsDto;", "Landroid/os/Parcelable;", "partOfSpeech", "", "definitions", "", "Lio/github/grishaninvyacheslav/domain/models/DefinitionDto;", "(Ljava/lang/String;Ljava/util/List;)V", "getDefinitions", "()Ljava/util/List;", "getPartOfSpeech", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "domain_debug"})
public final class MeaningsDto implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.Expose()
    private final java.lang.String partOfSpeech = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.Expose()
    private final java.util.List<io.github.grishaninvyacheslav.domain.models.DefinitionDto> definitions = null;
    public static final android.os.Parcelable.Creator<io.github.grishaninvyacheslav.domain.models.MeaningsDto> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.github.grishaninvyacheslav.domain.models.MeaningsDto copy(@org.jetbrains.annotations.NotNull()
    java.lang.String partOfSpeech, @org.jetbrains.annotations.NotNull()
    java.util.List<io.github.grishaninvyacheslav.domain.models.DefinitionDto> definitions) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public MeaningsDto(@org.jetbrains.annotations.NotNull()
    java.lang.String partOfSpeech, @org.jetbrains.annotations.NotNull()
    java.util.List<io.github.grishaninvyacheslav.domain.models.DefinitionDto> definitions) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPartOfSpeech() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<io.github.grishaninvyacheslav.domain.models.DefinitionDto> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<io.github.grishaninvyacheslav.domain.models.DefinitionDto> getDefinitions() {
        return null;
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<io.github.grishaninvyacheslav.domain.models.MeaningsDto> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final io.github.grishaninvyacheslav.domain.models.MeaningsDto createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final io.github.grishaninvyacheslav.domain.models.MeaningsDto[] newArray(int size) {
            return null;
        }
    }
}
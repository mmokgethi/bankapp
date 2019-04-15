package com.bbd.modisa.mapper;

public abstract class ModelMapper<DTO,DB> {

    public abstract DTO dbToDto(DB db);
    public abstract DB dtoToDb(DTO dto);
}

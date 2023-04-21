package com.iti.sakila.bussiness.mapper.filmmapper;

import com.iti.sakila.bussiness.dtos.categorydto.CategoryDto;
import com.iti.sakila.persistance.entity.Category;
import com.iti.sakila.persistance.entity.Film;
import com.iti.sakila.persistance.entity.FilmCategory;
import com.iti.sakila.persistance.entity.FilmCategoryId;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T03:51:06+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class FilmCategoryMapperImpl implements FilmCategoryMapper {

    @Override
    public CategoryDto toDto(FilmCategory filmCategory) {
        if ( filmCategory == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCategoryId( filmCategoryCategoryCategoryId( filmCategory ) );
        categoryDto.setName( filmCategoryCategoryName( filmCategory ) );

        return categoryDto;
    }

    @Override
    public FilmCategory toEntity(CategoryDto category, Film film) {
        if ( category == null && film == null ) {
            return null;
        }

        FilmCategory filmCategory = new FilmCategory();

        if ( category != null ) {
            if ( filmCategory.getId() == null ) {
                filmCategory.setId( new FilmCategoryId() );
            }
            categoryDtoToFilmCategoryId( category, filmCategory.getId() );
            filmCategory.setCategory( categoryDtoToCategory( category ) );
        }
        if ( film != null ) {
            if ( filmCategory.getId() == null ) {
                filmCategory.setId( new FilmCategoryId() );
            }
            filmToFilmCategoryId( film, filmCategory.getId() );
            filmCategory.setFilm( filmToFilm( film ) );
            filmCategory.setLastUpdate( film.getLastUpdate() );
        }

        return filmCategory;
    }

    private int filmCategoryCategoryCategoryId(FilmCategory filmCategory) {
        if ( filmCategory == null ) {
            return 0;
        }
        Category category = filmCategory.getCategory();
        if ( category == null ) {
            return 0;
        }
        int categoryId = category.getCategoryId();
        return categoryId;
    }

    private String filmCategoryCategoryName(FilmCategory filmCategory) {
        if ( filmCategory == null ) {
            return null;
        }
        Category category = filmCategory.getCategory();
        if ( category == null ) {
            return null;
        }
        String name = category.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    protected void categoryDtoToFilmCategoryId(CategoryDto categoryDto, FilmCategoryId mappingTarget) {
        if ( categoryDto == null ) {
            return;
        }

        mappingTarget.setCategoryId( categoryDto.getCategoryId() );
    }

    protected void filmToFilmCategoryId(Film film, FilmCategoryId mappingTarget) {
        if ( film == null ) {
            return;
        }

        if ( film.getFilmId() != null ) {
            mappingTarget.setFilmId( film.getFilmId() );
        }
    }

    protected Category categoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryId( categoryDto.getCategoryId() );

        return category;
    }

    protected Film filmToFilm(Film film) {
        if ( film == null ) {
            return null;
        }

        Film film1 = new Film();

        film1.setFilmId( film.getFilmId() );

        return film1;
    }
}

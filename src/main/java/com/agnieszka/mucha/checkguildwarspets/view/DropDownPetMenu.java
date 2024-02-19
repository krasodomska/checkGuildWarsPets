package com.agnieszka.mucha.checkguildwarspets.view;

import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.Route;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Route("/petForm")
public class ExpirationField extends CustomField<String> {
    private final List<String> PETS = IntStream.range(1, 67)
            .mapToObj(pet -> String.format("%d", pet))
            .collect(Collectors.toList());

    private final Select<String> pet = new Select<String>();


    public ExpirationField() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setPadding(false);
        layout.setSpacing(false);
        layout.getThemeList().add("spacing-xs");

        pet.setItems(PETS);
        pet.setPlaceholder("Pet");
        // Set title for screen readers
        pet.getElement().executeJs(
                "this.focusElement.setAttribute('title', 'Pet');");
        layout.add(pet);


        add(layout);
    }

    @Override
    protected String generateModelValue() {
        String monthValue = pet.getValue();


        if (monthValue == pet.getEmptyValue()
                ) {
            return null;
        }

        return String.join( monthValue.toString());
    }

    @Override
    protected void setPresentationValue(String expiration) {
        if (expiration == null) {
            pet.setValue(null);
        } else {
            pet.setValue(expiration);

        }

    }
}


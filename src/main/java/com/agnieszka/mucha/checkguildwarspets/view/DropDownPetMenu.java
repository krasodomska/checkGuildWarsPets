package com.agnieszka.mucha.checkguildwarspets.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class DropDownPetMenu extends CustomField<String> {
    private final List<String> PETS = IntStream.range(1, 67)
            .mapToObj(pet -> String.format("%d", pet))
            .collect(Collectors.toList());

    private final Select<String> pet = new Select<String>();


    public DropDownPetMenu() {
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

        Button secondaryButton = new Button("Secondary");
        secondaryButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        add(layout);
    }

    @Override
    protected String generateModelValue() {
        return pet.getValue();
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


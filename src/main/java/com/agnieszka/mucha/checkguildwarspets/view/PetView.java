package com.agnieszka.mucha.checkguildwarspets.view;

import com.agnieszka.mucha.checkguildwarspets.PetController;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/pet")
public class PetView extends VerticalLayout {
    PetView() {
        DropDownPetMenu form = new DropDownPetMenu();

        Button secondaryButton = new Button("POST");
        secondaryButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        secondaryButton.addClickListener(clickEvent -> {
            System.out.println("I was clicced");
            System.out.println(form.getValue());
        });

        add(form);
        add(secondaryButton);
        PetController.getPet(12);
    }
}

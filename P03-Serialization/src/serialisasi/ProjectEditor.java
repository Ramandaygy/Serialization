/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serialisasi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class ProjectEditor {
    
    private ProjectConfig config;

    public ProjectEditor() {
        config = new ProjectConfig();
    }

    public ProjectResource getProjectResource() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(config);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ProjectResource resource = new ProjectResource();
        resource.setData(baos.toByteArray());

        return resource;
    }

    public void loadProjectResource(ProjectResource resource) {
        if (resource.getData() != null) {
            try (ByteArrayInputStream bais = new ByteArrayInputStream(resource.getData())) {
                ObjectInputStream ois = new ObjectInputStream(bais);
                config = (ProjectConfig) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
    ProjectEditor editor = new ProjectEditor();

    // Menyimpan konfigurasi
    ProjectResource resource = editor.getProjectResource();
    // Simpan file dengan menggunakan resource.getData()

    // Memuat konfigurasi
   
    // Gunakan konfigurasi yang dimuat
    ProjectConfig loadedConfig = editor.getConfig();
}

    private ProjectConfig getConfig() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}

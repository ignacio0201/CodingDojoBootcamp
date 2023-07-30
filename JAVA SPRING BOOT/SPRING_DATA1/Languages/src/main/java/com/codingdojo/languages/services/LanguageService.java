package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {

	// Agregando el language al repositorio como una dependencia
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
		// Return all languages
		public List<Language> allLanguages() {
			return languageRepository.findAll();
		}

		// Create a language
		public Language createLanguage(Language b) {
			return languageRepository.save(b);
		}

		// Find info language
		public Language findLanguage(Long id) {
			Optional<Language> optionalLanguage = languageRepository.findById(id);
			if (optionalLanguage.isPresent()) {
				return optionalLanguage.get();
			} else {
				return null;
			}
		}
//		//Update language
//		public Language updateLanguage(Long id, String name, String creator, String currentVersion) {
//			Optional<Language> optionalLanguage = languageRepository.findById(id);
//			if(optionalLanguage.isPresent()) {
//				optionalLanguage.get().setName(name);
//				optionalLanguage.get().setCreator(creator);
//				optionalLanguage.get().setCurrentVersion(currentVersion);
//			}
//			return languageRepository.save(optionalLanguage.get());
//		}
		
		//Update language 2
		public Language updateLanguage(Language language) {
			return languageRepository.save(language);
		}
		
		//Delete language
		public void deleteLanguage(Long id) {
				languageRepository.deleteById(id);
			}
	
}

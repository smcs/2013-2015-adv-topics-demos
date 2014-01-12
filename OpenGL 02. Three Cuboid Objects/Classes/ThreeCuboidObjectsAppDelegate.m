//
//  OpenGL_01____Three_Cuboid_ObjectsAppDelegate.m
//  OpenGL 01.++ Three Cuboid Objects
//
//  Created by Seth Battis on 3/9/11.
//  Copyright __MyCompanyName__ 2011. All rights reserved.
//

#import "ThreeCuboidObjectsAppDelegate.h"
#import "GLView.h"

@implementation ThreeCuboidObjectsAppDelegate

@synthesize window;
@synthesize glView;

- (void)applicationDidFinishLaunching:(UIApplication *)application {
    
	glView.animationInterval = 1.0 / kRenderingFrequency;
	[glView startAnimation];
}


- (void)applicationWillResignActive:(UIApplication *)application {
	glView.animationInterval = 1.0 / kInactiveRenderingFrequency;
}


- (void)applicationDidBecomeActive:(UIApplication *)application {
	glView.animationInterval = 1.0 / 60.0;
}


- (void)dealloc {
	[window release];
	[glView release];
	[super dealloc];
}

@end
